package com.owenxh.visby;

/**
 * {@link Sequencer} 测试类
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class TestSequencer {


    public static void main(String[] args) {
        Sequencer sequencer = new SequencerBuilder()
                .append(new DateSequencer())
                .append(FixedSequencer.fixedCharSequencer('X'))
                .append(new IntIncrementSequencer(), 10)
                .append(new SimpleCheckCodeSequencer(), 3)
                .append(new DateSequencer(), 2)
                .build();

        for (int i = 0; i < 20; i++) {
            System.out.println(sequencer.next());
        }
    }
}
