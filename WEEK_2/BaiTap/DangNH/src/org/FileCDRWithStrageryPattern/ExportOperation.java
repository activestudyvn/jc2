package org.FileCDRWithStrageryPattern;

import java.io.File;

/**
 * Created by 404NotFound on 11/5/2015.
 */
public interface ExportOperation {
    public void write(String source, File file);
    public void close();
}
