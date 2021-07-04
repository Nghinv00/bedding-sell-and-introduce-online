package com.nghinv.beddingsellintroduce.common.hanldeError;

/**
 * @author anuragdhunna
 */

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
