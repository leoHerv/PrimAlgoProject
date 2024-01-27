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
	@echo "\n>> Compilation done with success.\n"

$(OBJDIR)/%.class: $(SRCDIR)/%.java
	@mkdir -p $(@D)
	@$(JC) $(JFLAGS) -d $(OBJDIR) $<

PrimM:
	@if [ ! -d "$(OBJDIR)" ]; then make comp; fi
	@echo "\n"
	@$(JVM) -cp $(OBJDIR) src.PrimM $(ARGS)
	@echo "\n>> End of PrimM execution.\n"

PrimL:
	@if [ ! -d "$(OBJDIR)" ]; then make comp; fi
	@echo "\n"
	@$(JVM) -cp $(OBJDIR) src.PrimL $(ARGS)
	@echo "\n>> End of PrimL execution.\n"

GraphGenerator:
	@if [ ! -d "$(OBJDIR)" ]; then make comp; fi
	@echo "\n"
	@$(JVM) -cp $(OBJDIR) src.GraphGenerator $(ARGS)
	@echo "\n>> End of GraphGenerator execution.\n"
clean :
	@$(RM) -r $(OBJDIR)
	@echo "\n>> Object files clean with success.\n"
