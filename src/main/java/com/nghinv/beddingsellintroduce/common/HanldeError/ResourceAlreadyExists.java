package com.nghinv.beddingsellintroduce.common.hanldeError;

/**
 * @author anuragdhunna
 */
public class ResourceAlreadyExists extends RuntimeException {

    public ResourceAlreadyExists(String message) {
        super(message);
    }
}
