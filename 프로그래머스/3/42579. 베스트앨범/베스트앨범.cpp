#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
    map<string, int> m;
    for (int i = 0; i < genres.size(); i++) {
        m[genres[i]] += plays[i];
    }
    
    vector<pair<string, int>> v;
    for (auto a : m) {
        v.push_back({a.first, a.second});
    }
    
    sort(v.begin(), v.end(), [](auto a, auto b) {
       return a.second > b.second;
    });
    
    for (int i = 0; i < v.size(); i++) {
        m[v[i].first] = i;
    }
    
    // 장르, 재생 횟수, 고유 번호
    vector<pair<int, pair<int, int>>> vv;
    for (int i = 0; i < genres.size(); i++) {
        vv.push_back({m[genres[i]], {plays[i], i}});
    }
    
    sort(vv.begin(), vv.end(), [](auto a, auto b) {
        if (a.first == b.first) {
            return a.second.first > b.second.first;
        }
        else
            return a.first < b.first;
    });
    
    vector<int> answer;
    int gen = 0;
    int genCnt = 0;
    for (auto a : vv) {
        cout << a.first << " " << a.second.first << " " << a.second.second << endl;
        if (gen == a.first) {
            if (genCnt == 2) {
                continue;
            }
            genCnt++;
        } else {
            gen = a.first;
            genCnt = 1;
        }
        answer.push_back(a.second.second);
    }
    return answer;
}