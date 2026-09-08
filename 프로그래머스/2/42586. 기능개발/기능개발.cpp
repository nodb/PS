#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    int cnt = 0;
    int prev = 0;
    
    for (int i = 0; i < progresses.size(); i++) {
        int day = (100 - progresses[i]) / speeds[i];
        day += (100 - progresses[i]) % speeds[i] > 0 ? 1 : 0;
        
        if (prev >= day) {
            cnt++;
        }
        else {
            if (cnt > 0) {
                answer.push_back(cnt);
            }
            prev = day;
            cnt = 1;
        }
    }
    answer.push_back(cnt);
    
    return answer;
}