//
// Created by Asus on 14-01-2022.
//

#include<iostream>
#include <stack>
#include <string>
using namespace std;

//Function to return precedence of operators
class infixToPostfix
{
public:
    int precedence(char c) {
        if(c == '^')
            return 3;
        else if(c == '/' || c=='*')
            return 2;
        else if(c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

//function to convert infix expression to postfix expression
    string infToPost(string s) {

        stack<char> st; //inbuilt stack
        string result;

        for(int i = 0; i < s.length(); i++) {
            char current_char = s[i];
            if((current_char >= 'a' && current_char <= 'z') || (current_char >= 'A' && current_char <= 'Z'))
                result += current_char;
            else if(current_char == '(')
                st.push('(');
            else if(current_char == ')') {
                while(st.top() != '(')
                {
                    result += st.top();
                    st.pop();
                }
                st.pop();
            }
            else {
                while(!st.empty() && precedence(s[i]) <= precedence(st.top())) {
                    result += st.top();
                    st.pop();
                }
                st.push(current_char);
            }
        }
        while(!st.empty()) {
            result += st.top();
            st.pop();
        }

        return result;
    }
};
