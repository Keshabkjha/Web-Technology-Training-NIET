#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

class Question {
public:
    int id;
    string content;
    string author;
    int votes;
    bool isDeleted;
    int lastUpdateTime;
    
    Question(int id, const string& content, const string& author, int currentTime) 
        : id(id), content(content), author(author), votes(0), isDeleted(false), lastUpdateTime(currentTime) {}
    
    // Helper function to sort questions by votes
    static bool compareByVotes(Question* a, Question* b) {
        return a->votes > b->votes;
    }
};

class StackOverFlow {
public:
    int decayTime;
    int currentTime;
    
    StackOverFlow(int decayTime) : decayTime(decayTime), currentTime(0) {}
    
    void incrementTime() {
        currentTime++;
    }
};

class Soft : public StackOverFlow {
private:
    unordered_map<int, Question*> questions;
    unordered_map<string, vector<Question*>> authorQuestions;
    int nextId;
    
    void applyDecay(Question* q) {
        int timePassed = currentTime - q->lastUpdateTime;
        int decaySteps = timePassed / decayTime;
        if (decayTime > 0 && decaySteps > 0) {
            q->votes -= decaySteps;
            q->lastUpdateTime += decaySteps * decayTime;
        }
    }
    
public:
    Soft(int decayTime) : StackOverFlow(decayTime), nextId(0) {}
    
    ~Soft() {
        // Clean up dynamically allocated memory
        for (auto& pair : questions) {
            delete pair.second;
        }
    }
    
    int addQuestion(const string& content, const string& author) {
        incrementTime();
        Question* q = new Question(nextId, content, author, currentTime);
        questions[nextId] = q;
        
        // Add to author's questions
        authorQuestions[author].push_back(q);
        // Sort the author's questions by votes (descending)
        sort(authorQuestions[author].begin(), authorQuestions[author].end(), 
            [](const Question* a, const Question* b) {
                return a->votes > b->votes;
            });
        
        cout << "Question with id: " << nextId << " is added" << endl;
        return nextId++;
    }
    
    void deleteQuestion(int id) {
        incrementTime();
        auto it = questions.find(id);
        if (it == questions.end() || it->second->isDeleted) return;
        
        it->second->isDeleted = true;
        cout << "Question with id: " << id << " is deleted" << endl;
    }
    
    void upVote(int id) {
        incrementTime();
        auto it = questions.find(id);
        if (it == questions.end() || it->second->isDeleted) return;
        
        Question* q = it->second;
        applyDecay(q);
        q->votes++;
        q->lastUpdateTime = currentTime;
        cout << "Question with id: " << id << " is upvoted" << endl;
    }
    
    void downVote(int id) {
        incrementTime();
        auto it = questions.find(id);
        if (it == questions.end() || it->second->isDeleted) return;
        
        Question* q = it->second;
        applyDecay(q);
        q->votes--;
        q->lastUpdateTime = currentTime;
        cout << "Question with id: " << id << " is downvoted" << endl;
    }
    
    pair<string, int> getQuestionById(int id) {
        incrementTime();
        auto it = questions.find(id);
        if (it == questions.end() || it->second->isDeleted) {
            return {"null", 0};
        }
        
        Question* q = it->second;
        applyDecay(q);
        return {q->content, q->votes};
    }
    
    vector<string> getTop10QuestionsByAuthor(const string& author) {
        incrementTime();
        vector<string> result;
        auto it = authorQuestions.find(author);
        
        if (it == authorQuestions.end() || it->second.empty()) {
            return result;
        }
        
        // Get a copy of the author's questions
        vector<Question*> authorQs = it->second;
        
        // Apply decay and filter out deleted questions
        vector<Question*> validQuestions;
        for (Question* q : authorQs) {
            applyDecay(q);
            if (!q->isDeleted) {
                validQuestions.push_back(q);
            }
        }
        
        // Sort by votes (descending)
        sort(validQuestions.begin(), validQuestions.end(), 
            [](const Question* a, const Question* b) {
                return a->votes > b->votes;
            });
        
        // Get top 10 or less
        int count = min(10, (int)validQuestions.size());
        for (int i = 0; i < count; i++) {
            result.push_back(validQuestions[i]->content);
        }
        
        return result;
    }
};

int main() {
    int Q, decayTime;
    cin >> Q >> decayTime;
    cin.ignore(); // consume the newline
    
    Soft platform(decayTime);
    
    for (int i = 0; i < Q; i++) {
        string line;
        getline(cin, line);
        size_t firstSpace = line.find(' ');
        if (firstSpace == string::npos) continue;
        
        int queryType = stoi(line.substr(0, firstSpace));
        
        switch (queryType) {
            case 1: {
                // Find the last space which separates content from author
                size_t lastSpace = line.rfind(' ');
                if (lastSpace == string::npos || lastSpace <= firstSpace) continue;
                
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
                vector<string> topQuestions = platform.getTop10QuestionsByAuthor(author);
                for (const string& content : topQuestions) {
                    cout << content << endl;
                }
                break;
            }
        }
    }
    
    return 0;
}
