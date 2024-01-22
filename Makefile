# Al NATOUR Mazen and HERVOUET Leo
JFLAGS = -g
JC = javac
JVM = java
SRCDIR = src
OBJDIR = $(SRCDIR)/obj
SOURCES = $(wildcard $(SRCDIR)/*/*.java $(SRCDIR)/*.java)
OBJECTS = $(SOURCES:$(SRCDIR)/%.java=$(OBJDIR)/%.class)

ARGS = arg1 arg2 arg3

comp: $(OBJECTS)
	@echo "Compilation done with success.\n"

$(OBJDIR)/%.class: $(SRCDIR)/%.java
	@mkdir -p $(@D)
	@$(JC) $(JFLAGS) -d $(OBJDIR) $<

PrimM:
	@$(JVM) -cp $(OBJDIR) src.PrimM $(ARGS)

PrimL:
	@$(JVM) -cp $(OBJDIR) src.PrimL $(ARGS)

clean :
	@$(RM) -r $(OBJDIR)
	@echo "\nObject files clean with success.\n"
