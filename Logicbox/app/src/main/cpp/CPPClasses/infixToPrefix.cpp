//
// Created by Asus on 14-01-2022.
//

#include<iostream>
#include<string>
#include "infixToPostfix.cpp"
infixToPostfix i;
using namespace std;

//Function to return precedence of operators
class infixToPrefix
{
public:

    string infToPre(string infix)
    {
        int l = infix.size();
        reverse(infix.begin(), infix.end());
        for (int i = 0; i < l; i++) {

            if (infix[i] == '(') {
                infix[i] = ')';
                i++;
            }
            else if (infix[i] == ')') {
                infix[i] = '(';
                i++;
            }
        }

        string prefix = i.infToPost(infix);
        reverse(prefix.begin(), prefix.end());
        return prefix;
    }
};
