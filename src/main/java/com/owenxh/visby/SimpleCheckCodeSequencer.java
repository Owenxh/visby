package com.owenxh.visby;

import com.owenxh.visby.support.CheckCodeDecorator;

import java.io.Serializable;

/**
 * 序列号校验码装饰器
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class SimpleCheckCodeSequencer implements CheckCodeDecorator {

    @Override
    public Serializable decorate(Serializable sequence) {
        return hash(String.valueOf(sequence));
    }

    private static int hash(String sequence) {
        if ( sequence == null || sequence.length() == 0 ) {
            return 0;
        }
        char[] chs = sequence.toCharArray();
        int hash = 0;
        for ( int i = chs.length - 1 ; i >= 0 ; i-- ) {
            hash = hash * 31 + chs[i];
        }

        return hash & Integer.MAX_VALUE;

    }
}
