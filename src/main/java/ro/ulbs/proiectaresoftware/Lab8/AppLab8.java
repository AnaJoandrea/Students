package ro.ulbs.proiectaresoftware.Lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AppLab8 {

    public static void main(String[] args) {
        File fisierExcel = new File("laborator8_input.xlsx");
        citesteSiAfiseazaExcel(fisierExcel);
        copiazaSiCalculeazaMedia(fisierExcel, "laborator8_output2.xlsx");
        scrieMediaCuFormula(fisierExcel, "laborator8_output3.xlsx");
    }

    public static void citesteSiAfiseazaExcel(File file) {
        try (InputStream in = new FileInputStream(file);
                Workbook workbook = new XSSFWorkbook(in)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        default:
                            System.out.print("NECUNOSCUT\t\t");
                    }
                }
                System.out.println();
            }
        } catch (IOException ex) {
            System.out.println("A apărut o eroare la citirea fișierului: " + ex.getMessage());
        }
    }

    public static void copiazaSiCalculeazaMedia(File fisierInput, String numeFisierOutput) {
        try (InputStream in = new FileInputStream(fisierInput);
             Workbook workbookVechi = new XSSFWorkbook(in);
             Workbook workbookNou = new XSSFWorkbook()) {
            Sheet sheetVechi = workbookVechi.getSheetAt(0);
            Sheet sheetNou = workbookNou.createSheet("Note cu Medie");
            for (int i = 0; i <= sheetVechi.getLastRowNum(); i++) {
                Row randVechi = sheetVechi.getRow(i);
                if (randVechi == null) continue;
                Row randNou = sheetNou.createRow(i);
                int numarColoaneVechi = randVechi.getLastCellNum();
                for (int j = 0; j < numarColoaneVechi; j++) {
                    Cell celulaVeche = randVechi.getCell(j);
                    Cell celulaNoua = randNou.createCell(j);
                    if (celulaVeche != null) {
                        switch (celulaVeche.getCellType()) {
                            case STRING:
                                celulaNoua.setCellValue(celulaVeche.getStringCellValue());
                                break;
                            case NUMERIC:
                                celulaNoua.setCellValue(celulaVeche.getNumericCellValue());
                                break;
                            default:
                                celulaNoua.setCellValue("");
                        }
                    }
                }

                Cell celulaMedie = randNou.createCell(numarColoaneVechi);

                if (i == 0) {
                    celulaMedie.setCellValue("Media");
                } else {
                    double suma = 0;
                    int noteValide = 0;
                    for (int col = numarColoaneVechi - 3; col < numarColoaneVechi; col++) {
                        if (col >= 0) {
                            Cell celulaNota = randVechi.getCell(col);
                            if (celulaNota != null) {
                                if (celulaNota.getCellType() == CellType.NUMERIC) {
                                    suma += celulaNota.getNumericCellValue();
                                    noteValide++;
                                }
                                else if (celulaNota.getCellType() == CellType.STRING) {
                                    try {
                                        suma += Double.parseDouble(celulaNota.getStringCellValue());
                                        noteValide++;
                                    } catch (NumberFormatException e) {
                                    }
                                }
                            }
                        }
                    }
                    if (noteValide > 0) {
                        celulaMedie.setCellValue(suma / noteValide);
                    } else {
                        celulaMedie.setCellValue("N/A");
                    }
                }
            }
            try (FileOutputStream out = new FileOutputStream(numeFisierOutput)) {
                workbookNou.write(out);
                System.out.println("Fișierul " + numeFisierOutput + " a fost salvat!");
            }
        } catch (IOException ex) {
            System.out.println("Eroare la procesarea fișierelor: " + ex.getMessage());
        }
    }

    public static void scrieMediaCuFormula(File fisierInput, String numeFisierOutput) {
        try (InputStream in = new FileInputStream(fisierInput);
             Workbook workbookVechi = new XSSFWorkbook(in);
             Workbook workbookNou = new XSSFWorkbook()) {

            Sheet sheetVechi = workbookVechi.getSheetAt(0);
            Sheet sheetNou = workbookNou.createSheet("Note cu Formula");

            for (int i = 0; i <= sheetVechi.getLastRowNum(); i++) {
                Row randVechi = sheetVechi.getRow(i);
                if (randVechi == null) continue;

                Row randNou = sheetNou.createRow(i);
                int numarColoaneVechi = randVechi.getLastCellNum();
                for (int j = 0; j < numarColoaneVechi; j++) {
                    Cell celulaVeche = randVechi.getCell(j);
                    Cell celulaNoua = randNou.createCell(j);

                    if (celulaVeche != null) {
                        switch (celulaVeche.getCellType()) {
                            case STRING:
                                celulaNoua.setCellValue(celulaVeche.getStringCellValue());
                                break;
                            case NUMERIC:
                                celulaNoua.setCellValue(celulaVeche.getNumericCellValue());
                                break;
                            default:
                                celulaNoua.setCellValue("");
                        }
                    }
                }

                Cell celulaMedie = randNou.createCell(numarColoaneVechi);
                if (i == 0) {
                    celulaMedie.setCellValue("Media (Formula)");
                } else {
                    int randExcel = i + 1;
                    String formula = "AVERAGE(D" + randExcel + ":F" + randExcel + ")";
                    celulaMedie.setCellFormula(formula);
                }
            }
            try (FileOutputStream out = new FileOutputStream(numeFisierOutput)) {
                workbookNou.write(out);
                System.out.println("Fișierul " + numeFisierOutput + " a fost creat cu succes!");
            }
        } catch (IOException ex) {
            System.out.println("A apărut o eroare: " + ex.getMessage());
        }
    }
}
