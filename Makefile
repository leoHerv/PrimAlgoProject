# Al NATOUR Mazen and HERVOUET Leo
JFLAGS = -g
JC = javac
JVM = java
SRCDIR = src
OBJDIR = $(SRCDIR)/obj
SOURCES = $(wildcard $(SRCDIR)/*/*.java $(SRCDIR)/*.java)
OBJECTS = $(SOURCES:$(SRCDIR)/%.java=$(OBJDIR)/%.class)

comp: $(OBJECTS)
	@echo "Compilation done with success.\n"

$(OBJDIR)/%.class: $(SRCDIR)/%.java
	@mkdir -p $(@D)
	@$(JC) $(JFLAGS) -d $(OBJDIR) $<

run: comp
	@echo "Run examples :"
	@echo "> $(JVM) -cp $(OBJDIR) src.PrimM examples/graph.txt 1"
	@echo "> $(JVM) -cp $(OBJDIR) src.PrimL examples/graph.txt 1"

clean :
	@$(RM) -r $(OBJDIR)
	@echo "\nObject files clean with success.\n"
