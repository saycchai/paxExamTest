package com.cchai.test;

import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.warProbe;
import static org.ops4j.pax.exam.Info.getOps4jBaseVersion;
import static org.ops4j.pax.exam.Info.getPaxExamVersion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.ConfigurationFactory;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.ProbeBuilder;
import org.ops4j.pax.exam.TestProbeBuilder;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.options.WarProbeOption;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.ops4j.pax.exam.spi.war.WarTestProbeBuilderImpl;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
public class BaseTest implements ConfigurationFactory{

	@ProbeBuilder
	public TestProbeBuilder probe(TestProbeBuilder defaultProbe) {

		Option option = new WarProbeOption().autoClasspath(true)
		 .name("test")
		;

		return new WarTestProbeBuilderImpl(null, (WarProbeOption) option);
	}
	
    @Override
    public Option[] createConfiguration() {
        return options(
            warProbe()
            .library("target/test-classes")
            .library(
                maven("org.ops4j.pax.exam.samples", "pax-exam-sample1-service", getPaxExamVersion()))
            .library(
                maven("org.ops4j.pax.exam.samples", "pax-exam-sample1-model", getPaxExamVersion()))
            .library(maven("org.ops4j.pax.exam", "pax-exam-servlet-bridge", getPaxExamVersion()))
            .library(maven("org.ops4j.pax.exam", "pax-exam-cdi", getPaxExamVersion()))
            .library(maven("org.ops4j.pax.exam", "pax-exam", getPaxExamVersion()))
            .library(maven("org.ops4j.base", "ops4j-base-spi", getOps4jBaseVersion()))
            .library(maven("junit", "junit", "4.9"))
            );
    }

	@Test
	public void dummy()
	{
		assertNotNull("");
	}
}
