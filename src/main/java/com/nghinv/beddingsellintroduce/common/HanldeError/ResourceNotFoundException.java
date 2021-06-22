package com.nghinv.beddingsellintroduce.common.HanldeError;

/**
 * @author anuragdhunna
 */

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
