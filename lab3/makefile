# Makefile com.example

.SUFFIXES: .class .java

PACK=com\example
PACK1=com.example
TARG=App
JC="C:\Program Files\Eclipse Adoptium\jdk-17.0.1.12-hotspot\bin\javac.exe" -g
JM="C:\Program Files\Eclipse Adoptium\jdk-17.0.1.12-hotspot\bin\java.exe" -ea -jar
JR="C:\Program Files\Eclipse Adoptium\jdk-17.0.1.12-hotspot\bin\jar.exe" -cfe

OBJ=$(PACK)\Abiturient.class \
    $(PACK)\App.class

.java.class:
	$(JC) $<

run: build
	$(JM) $(TARG).jar

build: 	$(OBJ)
	$(JR) $(TARG).jar $(PACK1).App $(OBJ)

clean:
	for %%f in ($(OBJ)) do del %%f
	del $(TARG).jar

$(PACK)\Abiturient.class: $(PACK)\Abiturient.java Makefile

$(PACK)\App.class: $(PACK)\App.java Makefile

# eof Makefile com.example