package com.owenxh.visby;

import com.owenxh.visby.support.FixedLengthDecorator;

/**
 * {@link Sequencer} 测试类
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class TestSequencer {


    public static void main(String[] args) {
        Sequencer sequencer = new SequencerBuilder()
                .append(FixedSequencer.fixedStringSequencer("A-"))
                .append(new FormatableSequencer(new IntIncrementSequencer(Integer.MAX_VALUE), new FixedLengthDecorator(10)))
                .append(FixedSequencer.fixedCharSequencer('-'))
                .append(new IntIncrementSequencer(0))
                .build();


        for (int i = 0; i < 10; i++) {
            System.out.println(sequencer.next());
        }
    }
}
