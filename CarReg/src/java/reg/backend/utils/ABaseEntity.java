/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.backend.utils;

import java.io.Serializable;

/**
 * @author duncan
 */
public abstract class ABaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract Long getIdentifier();
}