package com.aptechph.aptechblog.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fileName;
    private long fieldName;

    public ResourceNotFoundException(String resourceName, String fileName, long fieldName) {
        super(String.format("%s not $s = not found %s", resourceName, fileName, fieldName));
        this.resourceName = resourceName;
        this.fileName = fileName;
        this.fieldName = fieldName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFieldName() {
        return fieldName;
    }
}
