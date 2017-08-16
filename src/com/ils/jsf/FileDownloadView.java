package com.ils.jsf;

import java.io.IOException;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

 
@ManagedBean
public class FileDownloadView {
     
    private StreamedContent downloadFile;
     
    public FileDownloadView() throws IOException {        
    	InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/ajaxloadingbar.gif");
        downloadFile = new DefaultStreamedContent(stream, "image/gif", "bar.gif");
    }
    
    public StreamedContent getDownloadFile() {
        return downloadFile;
    }
    public void setDownloadFile(FileUploadView file) throws IOException {
        downloadFile = new DefaultStreamedContent(file.getFile().getInputstream(), file.getFileLoc());
    }
}