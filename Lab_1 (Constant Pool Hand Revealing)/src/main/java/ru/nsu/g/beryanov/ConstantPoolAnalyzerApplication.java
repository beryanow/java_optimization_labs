package ru.nsu.g.beryanov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.service.ConstantPoolAnalyzer;
import ru.nsu.g.beryanov.utility.FileReader;

import java.util.ArrayList;

@SpringBootApplication
public class ConstantPoolAnalyzerApplication implements CommandLineRunner {
    private final ConstantPoolAnalyzer constantPoolAnalyzer;
    private final FileReader fileReader;

    @Autowired
    public ConstantPoolAnalyzerApplication(ConstantPoolAnalyzer constantPoolAnalyzer, FileReader fileReader) {
        this.constantPoolAnalyzer = constantPoolAnalyzer;
        this.fileReader = fileReader;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConstantPoolAnalyzerApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        constantPoolAnalyzer.missMagicNumber(fileReader.getFileInputStream());

        short[] versions = constantPoolAnalyzer.getVersions(fileReader.getFileInputStream());
        short minorVersion = versions[0];
        short majorVersion = versions[1];

        short constantPoolCount = constantPoolAnalyzer.getConstantPoolCount(fileReader.getFileInputStream());
        ArrayList<Constant> constantArrayList = constantPoolAnalyzer.getConstantPool(fileReader.getFileInputStream(), constantPoolCount);

        constantPoolAnalyzer.showResult(majorVersion, minorVersion, (short) (constantPoolCount - 1), constantArrayList);
    }
}
