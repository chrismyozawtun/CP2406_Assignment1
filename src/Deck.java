/**
 * Created by Mick White #12862610 on 12/09/16.
 */
public class Deck {
    public Card[]cards;

    //create the playing Deck
    public Deck(){
        cards = new Card[60];
        cards[0] = new SupertrumpsCard("Quartz", "Sio2", "tectosilicate", "hexagonal",
                "igneous metamorphic sedimentary", 7.0, 2.65, "poor/none", "high", "moderate");

        cards[1] = new SupertrumpsCard("Plagioclase", "NaAlSi3O8 - CaAl2Si2O8", "tectosilicate", "triclinic",
                "igneous metamorphic sedimentary", 6.5, 2.8, "1 perfect, 1 good", "very high", "moderate");

        cards[2] = new SupertrumpsCard("Orthoclase", "KAlSi3O8", "tectosilicate", "monoclinic",
                "igneous metamorphic sedimentary", 6.5, 2.6, "1 perfect, 1 good", "high", "moderate");

        cards[3] = new SupertrumpsCard("Biotite", "K(Fe,Mg)3AlSi3O10(OH)2", "phyllosilicate", "monoclinic",
                "igneous metamorphic", 3.0, 3.3, "1 perfect", "moderate", "low");
        cards[4] = new SupertrumpsCard("Muscovite", "KAl3Si3O10(OH)2", "phyllosilicate", "monoclinic",
                "igneous metamorphic", 3.0, 2.9, "1 perfect", "moderate", "moderate");
        cards[5] = new SupertrumpsCard("The Miner", "Economic Value");
        cards[6] = new SupertrumpsCard("Hornblende", "Ca2(Mg,Fe)4Al2Si7O22(OH)2", "inosilicate", "monoclinic",
                "igneous metamorphic", 6.0, 3.5, "2 good", "moderate", "trivial");
        cards[7] = new SupertrumpsCard("Actinolite", "Ca2(Mg,Fe)5Si8O22(OH)2", "inosilicate", "monoclinic",
                "metamorphic", 6.0, 3.5, "2 good", "low", "low");
        cards[8] = new SupertrumpsCard("Glaucophane", "Na2(Mg,Fe)3Al2Si8O22(OH)2", "inosilicate", "monoclinic",
                "metamorphic", 6.0, 3.2, "2 good", "low", "trivial");
        cards[9] = new SupertrumpsCard("Olivine", "(Mg,Fe)2SiO4", "nesosilicate", "orthorombic",
                "igneous metamorphic mantle", 7.0, 4.4, "2 poor", "high", "low");
        cards[10] = new SupertrumpsCard("Garnet", "(Fe,Mg,Ca,Mn)3(Al,Fe)2Si3O12", "nesosilicate", "isometric",
                "igneous metamorphic mantle", 7.5, 4.3, "none", "moderate", "moderate");
        cards[11] = new SupertrumpsCard("Titanite", "CaTiSiO5", "nesosilicate", "monoclinic",
                "igneous metamorphic", 5.5, 3.6, "3 good", "low", "low");
        cards[12] = new SupertrumpsCard("Zircon", "ZrSiO4", "nesosilicate", "tetragonal",
                "igneous metamorphic sedimentary", 7.5, 4.7, "2 poor", "trace", "moderate");
        cards[13] = new SupertrumpsCard("Augite", "Ca(Mg,Fe)Si2O6", "inosilicate", "monoclinic",
                "igneous metamorphic", 6.5, 3.6, "2 good", "high", "trivial");
        cards[14] = new SupertrumpsCard("Orthopyroxene", "(Mg,Fe)2Si2O6", "inosilicate", "orthorombic",
                "igneous metamorphic mantle", 6.0, 3.9, "2 good", "high", "trivial");
        cards[15] = new SupertrumpsCard("The Petrologist", "Crustal Abundance");
        cards[16] = new SupertrumpsCard("Chlorite", "(Mg,Fe)5Al2Si3O10(OH)8", "phyllosilicate", "monoclinic",
                "metamorphic", 3.0, 3.3, "1 perfect", "moderate", "low");
        cards[17] = new SupertrumpsCard("Antigorite", "(Mg,Fe)3Si2O5(OH)4", "phyllosilicate", "monoclinic",
                "metamorphic mantle", 4.0, 2.6, "1 perfect", "low", "low");
        cards[18] = new SupertrumpsCard("Talc", "Mg3Si4O10(OH)2", "phyllosilicate", "monoclinic",
                "metamorphic", 1.0, 2.8, "1 perfect", "low", "moderate");
        cards[19] = new SupertrumpsCard("Kaolinite", "Al2Si2O5(OH)4", "phyllosilicate", "triclinic",
                "sedimentary", 2.5, 2.7, "1 perfect", "moderate", "high");
        cards[20] = new SupertrumpsCard("Andalusite", "Al2SiO5", "nesosilicate", "orthorhombic",
                "metamorphic", 7.0, 3.15, "2 good", "low", "moderate");
        cards[21] = new SupertrumpsCard("Kyanite", "Al2SiO5", "nesosilicate", "triclinic",
                "metamorphic", 7.0, 3.7, "1 perfect, 1 good", "trace", "moderate");
        cards[22] = new SupertrumpsCard("Sillimanite", "Al2SiO5", "nesosilicate", "orthorhombic",
                "igneous metamorphic", 7.5, 3.25, "1 perfect, 1 good", "low", "low");
        cards[23] = new SupertrumpsCard("Staurolite", "(Fe,Mg)2Al9Si4O22(OH)2", "nesosilicate", "monoclinic",
                "metamorphic", 7.0, 3.8, "1 good", "trace", "low");
        cards[24] = new SupertrumpsCard("Epidote", "Ca2(Al,Fe)3Si3O12(OH)", "sorosilicate", "monoclinic",
                "igneous metamorphic", 6.5, 3.5, "1 perfect", "moderate", "trivial");
        cards[25] = new SupertrumpsCard("The Gemologist", "Hardness");
        cards[26] = new SupertrumpsCard("Tourmaline", "Na(Mg,Fe)3Al6B3Si6O27(OH)4", "cyclosilicate", "hexagonal",
                "metamorphic", 7.5, 3.2, "2 poor", "trace", "moderate");
        cards[27] = new SupertrumpsCard("Topaz", "Al2SiO4(F,OH)2", "nesosilicate", "orthorhombic",
                "metamorphic sedimentary", 8.0, 3.6, "1 perfect", "ultratrace", "low");
        cards[28] = new SupertrumpsCard("Beryl", "Be3Al2Si6O18", "cyclosilicate", "hexagonal",
                "igneous metamorphic", 8.0, 2.9, "1 poor", "trace", "moderate");
        cards[29] = new SupertrumpsCard("Pyrite", "FeS2", "sulfide", "isometric",
                "igneous metamorphic", 6.5, 5.0, "2 poor", "low", "moderate");
        cards[30] = new SupertrumpsCard("Pyrrhotite", "Fe1-xS", "sulfide", "monoclinic",
                "igneous metamorphic", 4.5, 4.6, "none", "low", "moderate");
        cards[31] = new SupertrumpsCard("Chalcopyrite", "CuFeS2", "sulfide", "tetragonal",
                "igneous metamorphic", 4.0, 4.3, "2 poor", "low", "very high");
        cards[32] = new SupertrumpsCard("Galena", "PbS", "sulfide", "isometric",
                "metamorphic", 2.5, 7.6, "3 perfect", "trace", "high");
        cards[33] = new SupertrumpsCard("Sphalerite", "(Zn,Fe)S", "sulfide", "isometric",
                "metamorphic", 4.0, 4.1, "6 perfect", "trace", "high");
        cards[34] = new SupertrumpsCard("Molybdenite", "MoS2", "sulfide", "hexagonal",
                "igneous metamorphic", 1.5, 4.7, "1 perfect", "trace", "high");
        cards[35] = new SupertrumpsCard("The Mineralogist", "Cleavage");
        cards[36] = new SupertrumpsCard("Gold", "Au", "native element", "isometric",
                "metamorphic sedimentary", 3.0, 19.3, "none", "ultratrace", "I'm rich!");
        cards[37] = new SupertrumpsCard("Diamond", "C", "native element", "isometric",
                "igneous metamorphic sedimentary", 10.0, 3.5, "4 perfect", "ultratrace", "I'm rich!");
        cards[38] = new SupertrumpsCard("Graphite", "C", "native element", "hexagonal",
                "metamorphic sedimentary", 2.0, 2.2, "1 perfect", "trace", "moderate");
        cards[39] = new SupertrumpsCard("Halite", "NaCl", "halide", "isometric",
                "sedimentary", 2.5, 2.2, "3 perfect", "trace", "moderate");
        cards[40] = new SupertrumpsCard("Fluorite", "CaF2", "halide", "isometric",
                "metamorphic", 4.0, 3.2, "4 perfect", "trace", "moderate");
        cards[41] = new SupertrumpsCard("Gypsum", "CaSo4(H2O)2", "sulfate", "monoclinic",
                "metamorphic sedimentary", 2.0, 2.3, "1 perfect, 2 good", "trace", "high");
        cards[42] = new SupertrumpsCard("Barite", "BaSO4", "sulfate", "orthorhombic",
                "metamorphic sedimentary", 3.5, 4.5, "2 perfect, 1 good", "trace", "I'm drunk!");
        cards[43] = new SupertrumpsCard("Apatite", "Ca5(PO4)3(OH,F,Cl)", "phosphate", "hexagonal",
                "igneous metamorphic sedimentary", 5.0, 3.2, "2 poor", "low", "I'm hungry");
        cards[44] = new SupertrumpsCard("Monazite", "(La,Ce,Nd)PO4", "phosphate", "monoclinic",
                "igneous metamorphic sedimentary", 5.0, 5.3, "1 good, 1 poor", "trace", "moderate");
        cards[45] = new SupertrumpsCard("The Geophysicist", "Specific gravity or Magnetite");
        cards[46] = new SupertrumpsCard("Calcite", "CaCO3", "carbonate", "hexagonal",
                "igneous metamorphic sedimentary", 3.0, 2.7, "3 perfect", "moderate", "high");
        cards[47] = new SupertrumpsCard("Dolomite", "CaMg(CO3)2", "carbonate", "hexagonal",
                "metamorphic sedimentary", 3.5, 2.9, "3 perfect", "low", "i love greek food");
        cards[48] = new SupertrumpsCard("Magnesite", "MgCO3", "carbonate", "hexagonal",
                "metamorphic sedimentary", 4.0, 3.0, "3 perfect", "low", "moderate");
        cards[49] = new SupertrumpsCard("Siderite", "FeCO3", "carbonate", "hexagonal",
                "metamorphic sedimentary", 4.5, 4.0, "3 perfect", "trace", "moderate");
        cards[50] = new SupertrumpsCard("Magnetite", "Fe3O4", "oxide (spinel)", "isometric",
                "igneous metamorphic sedimentary", 6.0, 5.2, "none", "moderate", "very high");
        cards[51] = new SupertrumpsCard("Hematite", "Fe2O3", "oxide", "hexagonal",
                "metamorphic sedimentary", 6.0, 5.3, "none", "trace", "high");
        cards[52] = new SupertrumpsCard("Chromite", "(Fe,Mg)Cr2O4", "oxide (spinal)", "isometric",
        "igneous sedimentary", 5.5, 5.1, "none", "low", "high");
        cards[53] = new SupertrumpsCard("Ilmenite", "TiFeO3", "oxide", "hexagonal",
                "igneous metamorphic sedimentary", 6.0, 4.8, "none", "low", "moderate");
        cards[54] = new SupertrumpsCard("Rutile", "TiO2", "oxide", "tetragonal",
                "metamorphic sedimentary", 6.5, 4.3, "2 good", "low", "high");
        cards[55] = new SupertrumpsCard("The Geologist", "Any");
        cards[56] = new SupertrumpsCard("Corundum", "Al2O3", "oxide", "hexagonal",
                "metamorphic sedimentary", 9.0, 4.0, "none", "trace", "moderate");
        cards[57] = new SupertrumpsCard("Cassiterite", "SnO2", "oxide", "tetragonal",
                "igneous metamorphic sedimentary", 7.0, 7.1, "1 good, 1 poor", "trace", "high");
        cards[58] = new SupertrumpsCard("Gibbsite", "Al(OH)3", "hydroxide", "monoclinic",
                "metamorphic sedimentary", 3.5, 2.4, "1 perfect", "low", "high");
        cards[59] = new SupertrumpsCard("Geothite", "FeO(OH)", "hydroxide", "orthorhombic",
                "sedimentary", 5.5, 4.3, "1 perfect, 1 good", "moderate", "moderate");
    }
}
