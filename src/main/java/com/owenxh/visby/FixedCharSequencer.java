package com.owenxh.visby;


/**
 * 固定字符序列号
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 * @deprecated since {@link FixedSequencer#fixedCharSequencer(Character)}
 */
@Deprecated
public class FixedCharSequencer extends FixedSequencer implements Sequencer {

    public FixedCharSequencer(Character sequence) {
        super(sequence);
    }

}
