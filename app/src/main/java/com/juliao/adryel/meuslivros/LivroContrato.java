package com.juliao.adryel.meuslivros;

import android.provider.BaseColumns;

/**
 * Created by André Gomes e Adryel Julião on 06/09/2017.
 */

public final class LivroContrato {

    private LivroContrato(){

    }

    public static class LivroEntry implements BaseColumns{

        public static final String TABLE_NAME = "Livro";
        public static final String TITULO = "titulo";
        public static final String AUTOR = "autor";
        public static final String ANO = "ano";
        public static final String NOTA = "nota";
    }

}
