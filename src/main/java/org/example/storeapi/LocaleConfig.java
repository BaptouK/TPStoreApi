package org.example.storeapi;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@Configuration
public class LocaleConfig
{
    @Bean
    public LocaleResolver localeResolver() {
        // Locale forcée en anglais
        return new FixedLocaleResolver(Locale.ENGLISH);
    }
}