#!/bin/sh
all=`ls`

for d in $all; do
	if [ -d $d ]; then \
		echo "-----------clean $d"; 
		cd $d; make clean;cd -; \
	fi
done