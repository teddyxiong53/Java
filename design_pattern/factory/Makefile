
.PHONY: all clean static single multi

all: 
	@echo "make single or make multi or make static"
clean:
	-rm -f *.class
	
single: clean
	cp SendFactorySingle.java.bak SendFactory.java -f
	cp FactoryTestSingle.java.bak FactoryTest.java -f
	javac *.java
	
multi: clean
	cp SendFactoryMulti.java.bak SendFactory.java -f
	cp FactoryTestMulti.java.bak FactoryTest.java -f
	javac *.java
	
static: clean
	cp SendFactoryStatic.java.bak SendFactory.java -f
	cp FactoryTestStatic.java.bak FactoryTest.java -f
	javac *.java