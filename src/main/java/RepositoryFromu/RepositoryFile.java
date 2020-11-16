package RepositoryFromu;

import Interfaces.IXmlService;
import RepositoryFromu.Data.FromuResponse;
import Service.XmlService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RepositoryFile {

    public RepositoryFile(String path) {
        _path = path;
        new File(_path).mkdirs();
    }

    private final String _path;
    private final IXmlService _xmlService = new XmlService();

    public FromuResponse GetResponse(String fileName) throws Exception {

        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return _xmlService.Deserialize(content, FromuResponse.class);
    }
}