BASE_NAME := thesis
BUILD_DIR := build
PDF_NAME := GraduationThesisJoaoGuimaraes.pdf

PDFLATEX_OPTIONS = -halt-on-error -aux-directory=$(BUILD_DIR) -output-directory=$(BUILD_DIR)
LATEX     := latex
PDFLATEX  = pdflatex $(PDFLATEX_OPTIONS)
BIBTEX    := bibtex
#MAKEINDEX := makeindex

pdf: $(BASE_NAME).pdf

$(BASE_NAME).pdf: $(BASE_NAME).tex 
	mkdir -p $(BUILD_DIR)
	$(PDFLATEX) $<
	$(BIBTEX) $(BUILD_DIR)/$(BASE_NAME) 
#	$(MAKEINDEX) $(BUILD_DIR)/$(BASE_NAME) 
#	$(PDFLATEX) $< 
#	$(PDFLATEX) $<
	$(PDFLATEX) $<
	cp $(BUILD_DIR)/$(BASE_NAME).pdf $(PDF_NAME)

clean:
	rm -rf build $(PDF_NAME)
