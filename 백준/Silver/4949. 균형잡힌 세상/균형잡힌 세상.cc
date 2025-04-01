#include<iostream>
#include<string>
#include<stack>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    while(1){
        string st;
        getline(cin, st);
        if(st==".") break;
        stack<char> S;
        bool ans=true;
        for(auto c : st) {
            if (c=='(' || c=='[') S.push(c);
            else if (c==')') {
                if(S.empty() || S.top()!='(') {
                    ans = false;
                    break;
                }
                S.pop();
            }
            else if (c==']') {
                if(S.empty() || S.top()!='[') {
                    ans = false;
                    break;
                }
                S.pop();
            }
        }
        if(!S.empty()) ans = false;
        if(ans) cout << "yes\n";
        else cout << "no\n";
    }
}