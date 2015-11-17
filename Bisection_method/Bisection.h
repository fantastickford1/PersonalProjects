//
// Created by Karlos on 10/31/2015.
//

#ifndef BISECTION_METHOD_BISECTION_H
#define BISECTION_METHOD_BISECTION_H


class Bisection {


public:
    Bisection();

    ~Bisection();

    void setFunsion();

    void setTol(double tol);

    void setRange(double a, double b);

    void setItarator(int no);



};


#endif //BISECTION_METHOD_BISECTION_H
