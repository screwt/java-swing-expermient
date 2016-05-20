JAVAC=javac
sources = $(wildcard aeontdl/*.java)
classes = $(sources:.java=.class)

all: myProgram

myProgram: $(classes) jar

clean :
	rm -f aeontdl/*.class *.jar

%.class : %.java
	$(JAVAC) $<

jar: $(classes)
	jar -cvfm myjarfile.jar Manifest.txt $(classes) 
