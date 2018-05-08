package com.owenxh.visby;


/**
 * 固定字符串序列号
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 * @deprecated since {@link FixedSequencer#fixedStringSequencer(String)}
 */
@Deprecated
public class FixedStringSequencer extends FixedSequencer implements Sequencer {

    public FixedStringSequencer(String sequence) {
        super(sequence);
    }

}
