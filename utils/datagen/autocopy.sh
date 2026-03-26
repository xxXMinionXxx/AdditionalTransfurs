#!/bin/bash
find data -type f > cache

#TODO: Automate in a more elegant way
./vkstg.pl < data/klofs/LatexFox.klof | ./kstfg.pl -n LatexFox -P > ../../src/main/java/net/kjentytek303/additional_transfurs/entity/LatexFox.java 
./vkstg.pl < data/klofs/LatexPlantDragon.klof | ./kstfg.pl -n LatexPlantDragon -P > ../../src/main/java/net/kjentytek303/additional_transfurs/entity/LatexPlantDragon.java

./gtmpg.pl
./greg.pl < variants.greg

cp -R ./generated/java/registries/* ../../src/main/java/net/kjentytek303/additional_transfurs/init/
cp -R ./generated/data/* ../../src/main/resources/data/
