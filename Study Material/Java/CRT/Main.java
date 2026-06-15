import java.util.*;
import java.io.*;

class Question {
    int id;
    String content;
    String author;
    int votes;
    boolean isDeleted;
    int lastUpdateTime;
    
    public Question(int id, String content, String author, int currentTime) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.votes = 0;
        this.isDeleted = false;
        this.lastUpdateTime = currentTime;
    }
}

class StackOverFlow {
    public int decayTime = 0;
    public int currentTime = 0;
    
    public StackOverFlow(int decayTime) {
        this.decayTime = decayTime;
    }
    
    public void incrementTime() {
        currentTime++;
    }
}

// Simple Pair class to hold two values
class Pair<K, V> {
    K first;
    V second;
    
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Soft extends StackOverFlow {
    private Map<Integer, Question> questions;
    private Map<String, PriorityQueue<Question>> authorQuestions;
    private int nextId;
    
    public Soft(int decayTime) {
        super(decayTime);
        questions = new HashMap<>();
        authorQuestions = new HashMap<>();
        nextId = 0;
    }
    
    private void applyDecay(Question q) {
        int timePassed = currentTime - q.lastUpdateTime;
        int decaySteps = timePassed / decayTime;
        if (decayTime > 0 && decaySteps > 0) {
            q.votes -= decaySteps;
            q.lastUpdateTime += decaySteps * decayTime;
        }
    }
    
    public int addQuestion(String content, String author) {
        incrementTime();
        Question q = new Question(nextId, content, author, currentTime);
        questions.put(nextId, q);
        
        authorQuestions.computeIfAbsent(author, k -> new PriorityQueue<>(
            (a, b) -> {
                applyDecay(a);
                applyDecay(b);
                return b.votes - a.votes;
            }
        )).add(q);
        
        System.out.println("Question with id: " + nextId + " is added");
        return nextId++;
    }
    
    public void deleteQuestion(int id) {
        incrementTime();
        Question q = questions.get(id);
        if (q == null || q.isDeleted) return;
        
        q.isDeleted = true;
        System.out.println("Question with id: " + id + " is deleted");
    }
    
    public void upVote(int id) {
        incrementTime();
        Question q = questions.get(id);
        if (q == null || q.isDeleted) return;
        
        applyDecay(q);
        q.votes++;
        q.lastUpdateTime = currentTime;
        System.out.println("Question with id: " + id + " is upvoted");
    }
    
    public void downVote(int id) {
        incrementTime();
        Question q = questions.get(id);
        if (q == null || q.isDeleted) return;
        
        applyDecay(q);
        q.votes--;
        q.lastUpdateTime = currentTime;
        System.out.println("Question with id: " + id + " is downvoted");
    }
    
    public Pair<String, Integer> getQuestionById(int id) {
        incrementTime();
        Question q = questions.get(id);
        if (q == null || q.isDeleted) {
            return new Pair<>("null", 0);
        }
        
        applyDecay(q);
        return new Pair<>(q.content, q.votes);
    }
    
    public List<String> getTop10QuestionsByAuthor(String author) {
        incrementTime();
        PriorityQueue<Question> pq = authorQuestions.get(author);
        List<String> result = new ArrayList<>();
        
        if (pq == null || pq.isEmpty()) {
            return result;
        }
        
        // Temporary list to hold questions while we process them
        List<Question> temp = new ArrayList<>();
        
        while (!pq.isEmpty() && result.size() < 10) {
            Question q = pq.poll();
            applyDecay(q);
            
            if (!q.isDeleted) {
                result.add(q.content);
                temp.add(q);
            }
        }
        
        // Add the questions back to the priority queue
        pq.addAll(temp);
        
        return result;
    }
    
}

public class Main {
    // Main class implementation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        int decayTime = scanner.nextInt();
        Soft platform = new Soft(decayTime);
        
        scanner.nextLine(); // consume the newline
        
        for (int i = 0; i < Q; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int queryType = Integer.parseInt(parts[0]);
            
            switch (queryType) {
                case 1: {
                    // Reconstruct content which may contain spaces
                    StringBuilder content = new StringBuilder();
                    for (int j = 1; j < parts.length - 1; j++) {
                        if (j > 1) content.append(" ");
                        content.append(parts[j]);
                    }
                    String author = parts[parts.length - 1];
                    platform.addQuestion(content.toString(), author);
                    break;
                }
                case 2: {
                    int id = Integer.parseInt(parts[1]);
                    platform.deleteQuestion(id);
                    break;
                }
                case 3: {
                    int id = Integer.parseInt(parts[1]);
                    platform.upVote(id);
                    break;
                }
                case 4: {
                    int id = Integer.parseInt(parts[1]);
                    platform.downVote(id);
                    break;
                }
                case 5: {
                    int id = Integer.parseInt(parts[1]);
                    Pair<String, Integer> result = platform.getQuestionById(id);
                    System.out.println("Content: " + result.first + ", Vote: " + result.second);
                    break;
                }
                case 6: {
                    String author = parts[1];
                    List<String> topQuestions = platform.getTop10QuestionsByAuthor(author);
                    for (String content : topQuestions) {
                        System.out.println(content);
                    }
                    break;
                }
            }
        }
    }
}