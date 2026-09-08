#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    map<string, int> m;
    for (auto v : clothes) {
        m[v[1]]++;
    }
    int answer = 1;
    
    for (auto c : m) {
        answer *= c.second + 1;
    }
    
    return answer - 1;
}