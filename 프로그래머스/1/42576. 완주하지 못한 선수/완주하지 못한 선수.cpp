#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    map<string, int> m;
    
    for (int i = 0; i < participant.size(); i++) {
        m[participant[i]]++;
    }
    
    for (int i = 0; i < completion.size(); i++) {
        m[completion[i]]--;
    }
    
    for (auto person : m) {
        if (person.second == 1) {
            return person.first;
        }
    }
    
    return 0;
}