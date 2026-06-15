#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
#include <queue>
#include <memory>
#include <algorithm>

using namespace std;

struct Question {
    int id;
    string content;
    string author;
    int votes;
    bool isDeleted;
    int lastUpdateTime;
    
    Question(int id, const string& content, const string& author, int currentTime)
        : id(id), content(content), author(author), votes(0), isDeleted(false), lastUpdateTime(currentTime) {}
};

class StackOverFlow {
protected:
    int decayTime;
    int currentTime;
    
public:
    StackOverFlow(int decay) : decayTime(decay), currentTime(0) {}
    virtual ~StackOverFlow() = default;
    
    virtual int addQuestion(const string& content, const string& author) = 0;
    virtual void deleteQuestion(int id) = 0;
    virtual void upVote(int id) = 0;
    virtual void downVote(int id) = 0;
    virtual pair<string, int> getQuestionById(int id) = 0;
    virtual vector<string> getTop10QuestionsByAuthor(const string& author) = 0;
    
    void incrementTime() {
        currentTime++;
    }
    
    int getCurrentTime() const {
        return currentTime;
    }
};

class Soft : public StackOverFlow {
private:
    unordered_map<int, shared_ptr<Question>> questions;
    unordered_map<string, vector<shared_ptr<Question>>> authorQuestions;
    int nextId;
    
    struct CompareVotes {
        bool operator()(const shared_ptr<Question>& a, const shared_ptr<Question>& b) {
            return a->votes < b->votes; // Max-heap based on votes
        }
    };
    
    void applyDecay(shared_ptr<Question> q) {
        if (!q || q->isDeleted) return;
        
        int timePassed = getCurrentTime() - q->lastUpdateTime;
        int decaySteps = timePassed / decayTime;
        
        if (decayTime > 0 && decaySteps > 0) {
            q->votes -= decaySteps;
            q->lastUpdateTime += decaySteps * decayTime;
        }
    }
    
public:
    Soft(int decay) : StackOverFlow(decay), nextId(0) {}
    
    int addQuestion(const string& content, const string& author) override {
        incrementTime();
        auto q = make_shared<Question>(nextId, content, author, getCurrentTime());
        questions[nextId] = q;
        
        // Add to author's questions
        authorQuestions[author].push_back(q);
        // Sort the author's questions by votes (descending)
        sort(authorQuestions[author].begin(), authorQuestions[author].end(),
            [](const shared_ptr<Question>& a, const shared_ptr<Question>& b) {
                return a->votes > b->votes;
            });
        
        cout << "Question with id: " << nextId << " is added" << endl;
        return nextId++;
    }
    
    void deleteQuestion(int id) override {
        incrementTime();
        auto it = questions.find(id);
        if (it == questions.end() || it->second->isDeleted) return;
        
        it->second->isDeleted = true;
        cout << "Question with id: " << id << " is deleted" << endl;
    }
    
    void upVote(int id) override {
        incrementTime();
        auto it = questions.find(id);
        if (it == questions.end() || it->second->isDeleted) return;
        
        applyDecay(it->second);
        it->second->votes++;
        it->second->lastUpdateTime = getCurrentTime();
        cout << "Question with id: " << id << " is upvoted" << endl;
    }
    
    void downVote(int id) override {
        incrementTime();
        auto it = questions.find(id);
        if (it == questions.end() || it->second->isDeleted) return;
        
        applyDecay(it->second);
        it->second->votes--;
        it->second->lastUpdateTime = getCurrentTime();
        cout << "Question with id: " << id << " is downvoted" << endl;
    }
    
    pair<string, int> getQuestionById(int id) override {
        incrementTime();
        auto it = questions.find(id);
        if (it == questions.end() || it->second->isDeleted) {
            return {"null", 0};
        }
        
        applyDecay(it->second);
        return {it->second->content, it->second->votes};
    }
    
    vector<string> getTop10QuestionsByAuthor(const string& author) override {
        incrementTime();
        vector<string> result;
        auto it = authorQuestions.find(author);
        
        if (it == authorQuestions.end()) {
            return result;
        }
        
        // Create a copy of the author's questions and sort by votes
        vector<shared_ptr<Question>> authorQs = it->second;
        // Remove deleted questions and apply decay
        authorQs.erase(
            remove_if(authorQs.begin(), authorQs.end(), 
                     [this](const shared_ptr<Question>& q) {
                         if (q->isDeleted) return true;
                         applyDecay(q);
                         return false;
                     }),
            authorQs.end()
        );
        
        // Sort by votes (descending)
        sort(authorQs.begin(), authorQs.end(),
            [](const shared_ptr<Question>& a, const shared_ptr<Question>& b) {
                return a->votes > b->votes;
            });
        
        // Get top 10 or less
        int count = min(10, static_cast<int>(authorQs.size()));
        for (int i = 0; i < count; i++) {
            result.push_back(authorQs[i]->content);
        }
        
        return result;
    }
};

int main() {
    int Q, decayTime;
    cin >> Q >> decayTime;
    
    Soft platform(decayTime);
    cin.ignore(); // Consume the newline
    
    for (int i = 0; i < Q; i++) {
        string line;
        getline(cin, line);
        size_t firstSpace = line.find(' ');
        int queryType = stoi(line.substr(0, firstSpace));
        
        switch (queryType) {
            case 1: {
                // Find the last space to separate content and author
                size_t lastSpace = line.rfind(' ');
                string content = line.substr(firstSpace + 1, lastSpace - firstSpace - 1);
                string author = line.substr(lastSpace + 1);
                platform.addQuestion(content, author);
                break;
            }
            case 2: {
                int id = stoi(line.substr(firstSpace + 1));
                platform.deleteQuestion(id);
                break;
            }
            case 3: {
                int id = stoi(line.substr(firstSpace + 1));
                platform.upVote(id);
                break;
            }
            case 4: {
                int id = stoi(line.substr(firstSpace + 1));
                platform.downVote(id);
                break;
            }
            case 5: {
                int id = stoi(line.substr(firstSpace + 1));
                auto result = platform.getQuestionById(id);
                cout << "Content: " << result.first << ", Vote: " << result.second << endl;
                break;
            }
            case 6: {
                string author = line.substr(firstSpace + 1);
                auto topQuestions = platform.getTop10QuestionsByAuthor(author);
                cout << "Top questions by " << author << ":" << endl;
                for (const auto& q : topQuestions) {
                    cout << "\"" << q << "\"" << endl;
                }
                break;
            }
        }
    }
    
    return 0;
}
