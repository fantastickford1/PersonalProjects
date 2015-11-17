cmake_minimum_required(VERSION 3.3)
project(Bisection_method)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp Bisection.cpp Bisection.h)
add_executable(Bisection_method ${SOURCE_FILES})