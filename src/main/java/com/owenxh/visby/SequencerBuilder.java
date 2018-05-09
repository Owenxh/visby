package com.owenxh.visby;

import com.owenxh.visby.support.CheckCodeDecorator;
import com.owenxh.visby.support.FixedLengthDecorator;
import com.owenxh.visby.util.Assert;

import java.io.Serializable;

/**
 * {@link Sequencer} builder
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class SequencerBuilder {

    private CombinableSequencerSupport delegated;

    public SequencerBuilder() {
        this.delegated = new CombinableSequencerSupport();
    }

    public SequencerBuilder append(Sequencer combined) {
        Assert.notNull(delegated, "[delegated] must not be null");

        this.delegated.with(combined);

        return this;
    }

    public SequencerBuilder append(Sequencer combined, int seqLength) {
        this.delegated.with(new DelegatableSequencer(combined, new FixedLengthDecorator(seqLength)));

        return this;
    }

    public SequencerBuilder append(CheckCodeDecorator decorator, int checkCodeLength) {
        Sequencer sequencer = new DelegatableSequencer(CombinableSequencerSupport.from(this.delegated), (sequence) -> {

            Serializable checkCode = decorator.decorate(sequence);
            return combination(sequence, new FixedLengthDecorator(checkCodeLength).decorate(checkCode));
        });

        this.delegated.clear().with(sequencer);
        return this;
    }

    private String combination(Serializable sequence, Serializable checkCode) {
        return String.valueOf(sequence) + String.valueOf(checkCode);
    }

    public Sequencer build() {
        return delegated;
    }
}
