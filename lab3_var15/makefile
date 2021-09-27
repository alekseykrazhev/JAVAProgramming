# makefile package1

.SUFFIXES: .class .java

PACK=package1
TARG=App
JC=javac -g
JM=java -ea -jar
JR=jar -cfe

OBJ=$(PACK)\Abiturient.class \
    $(PACK)\App.class

.java.class:
	$(JC) $<

run: build
	$(JM) $(TARG).jar

build: 	$(OBJ)
	$(JR) $(TARG).jar $(PACK).test $(OBJ)

clean:
	for %%f in ($(OBJ)) do del %%f
	del $(TARG).jar

$(PACK)\Abiturient.class: $(PACK)\Abiturient.java makefile

$(PACK)\App.class: $(PACK)\App.java makefile

# eof makefile package1