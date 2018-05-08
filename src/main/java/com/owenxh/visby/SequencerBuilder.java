package com.owenxh.visby;

import com.owenxh.visby.util.Assert;

/**
 * {@link Sequencer} builder
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class SequencerBuilder {

    private CombinableSequencer sequencer;

    public SequencerBuilder() {
        this.sequencer = new CombinableSequencerSupport();
    }

    public SequencerBuilder append(Sequencer combined) {
        Assert.notNull(sequencer, "[sequencer] must not be null");

        this.sequencer.with(combined);

        return this;
    }

    public Sequencer build() {
        return sequencer;
    }
}
