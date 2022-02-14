//
// Created by Asus on 14-01-2022.
//

#include<iostream>
#include <stack>
#include <string>
using namespace std;
class postfixToPrefix
{
public:
bool isOperator(char x)
{
    switch (x) {
        case '+':
        case '-':
        case '/':
        case '*':
            return true;
    }
    return false;
}

// Convert postfix to Prefix expression
string postToPre(string post_exp)
{
    stack<string> s;
    int length = post_exp.size();
    for (int i = 0; i < length; i++) {
        if (isOperator(post_exp[i])) {
            string op1 = s.top();
            s.pop();
            string op2 = s.top();
            s.pop();
            string temp = post_exp[i] + op2 + op1;
            s.push(temp);
        }
        else {
            s.push(string(1, post_exp[i]));
        }
    }
    string ans = "";
    while (!s.empty()) {
        ans += s.top();
        s.pop();
    }
    return ans;
}
};