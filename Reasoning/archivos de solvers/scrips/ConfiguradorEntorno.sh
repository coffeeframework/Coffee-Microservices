#!/bin/bash
echo "export PATH=\$PATH:$(pwd)" >> ~/.bash_profile 
echo source  ~/.bash_profile  
echo minizinc --solvers