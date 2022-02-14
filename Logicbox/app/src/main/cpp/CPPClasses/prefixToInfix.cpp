//
// Created by Asus on 14-01-2022.
//

#include<iostream>
#include <stack>
#include <string>
using namespace std;
class prefixToInfix
{
public:
bool isOperator(char x) {
    switch (x) {
        case '+':
        case '-':
        case '/':
        case '*':
            return true;
    }
    return false;
}

// Convert prefix to Infix expression
string preToInfix(string pre_exp) {
    stack<string> s;
    int length = pre_exp.size();
    for (int i = length - 1; i >= 0; i--) {
        if (isOperator(pre_exp[i])) {
            string op1 = s.top();   s.pop();
            string op2 = s.top();   s.pop();
            string temp = "(" + op1 + pre_exp[i] + op2 + ")";
            s.push(temp);
        }
        else {
            s.push(string(1, pre_exp[i]));
        }
    }
    return s.top();
}
};