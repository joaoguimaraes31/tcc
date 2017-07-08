#!/bin/bash
make

#default option no flag, erase auxiliary files and opens output pdf
if [ $# -eq 0 ]
then
        rm -f *~ *.dvi *.ps *.backup *.aux *.log
	rm -f *.lof *.lot *.bbl *.blg *.brf *.toc *.idx
	gnome-open tcc.pdf       
	exit 0
fi

while getopts "orc" OPTION
do
	case $OPTION in
		o)
			#does not erase auxiliary files but opens output pdf
			gnome-open tcc.pdf
			exit
			;;
		r)
			#erase auxiliary files but does not open output pdf
        		rm -f *~ *.dvi *.ps *.backup *.aux *.log
			rm -f *.lof *.lot *.bbl *.blg *.brf *.toc *.idx
			exit
			;;
		c)
			#only compiles text document
			exit
			;;
	esac
done
