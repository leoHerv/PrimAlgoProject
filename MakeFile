##################################################
##			    SIMPLE MAKEFILE 	       	    ##
##################################################
JFLAGS = -g
JC = javac
JVM = java
SRCDIR = src
OBJDIR = $(SRCDIR)/obj
SOURCES = $(wildcard $(SRCDIR)/*/*.java $(SRCDIR)/*.java)
OBJECTS = $(SOURCES:$(SRCDIR)/%.java=$(OBJDIR)/%.class)

all: $(OBJECTS)
	@echo "--> Compilation terminee avec succes !\n"

$(OBJDIR)/%.class: $(SRCDIR)/%.java
	@mkdir -p $(@D)
	@$(JC) $(JFLAGS) -d $(OBJDIR) $<

run : all
	@$(JVM) -cp $(OBJDIR) Main

clean :
	@$(RM) -r $(OBJDIR)
	@echo "\n--> Tous les .class ont ete supprimes avec succes !\n"
