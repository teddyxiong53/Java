
.PHONY: all clean one two three

all: 
	@echo "make one/two/three"
clean:
	-rm -f *.class
	
one: clean
	cp Singleton1.java.bak Singleton.java -f
	javac *.java
	
two: clean
	cp Singleton2.java.bak Singleton.java -f
	javac *.java
	
three: clean
	cp Singleton3.java.bak Singleton.java -f
	javac *.java