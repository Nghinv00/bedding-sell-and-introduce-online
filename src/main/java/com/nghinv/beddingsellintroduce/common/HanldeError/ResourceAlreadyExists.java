package com.nghinv.beddingsellintroduce.common.HanldeError;

/**
 * @author anuragdhunna
 */
public class ResourceAlreadyExists extends RuntimeException {

    public ResourceAlreadyExists(String message) {
        super(message);
    }
}
