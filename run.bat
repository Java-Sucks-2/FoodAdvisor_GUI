javac src/classes/*.java -d bin -cp bin
javac src/util/*.java -d bin -cp bin
javac src/gui/components/*.java -d bin -cp bin
javac src/gui/pages/*.java -d bin -cp bin
javac src/clienti/*.java -d bin -cp bin
javac src/ristoratori/*.java -d bin -cp bin

cd bin

jar cmf ManifestRistoratori.mf Ristoratori.jar src/ristoratori/*.class src/classes/*.class src/gui/components/*.class src/gui/pages/*.class src/util/*.class ../assets/*.png ../assets/Manrope/static/*.ttf
jar cmf ManifestClienti.mf Clienti.jar src/clienti/*.class src/util/*.class src/classes/*.class src/gui/components/*.class src/gui/pages/*.class ../assets/*.png ../assets/Manrope/static/*.ttf