package io.github.enbool.dict.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/6 19:17
 */
@NoArgsConstructor
@Data
public class YouDaoJson {

    @JsonProperty("wordRank")
    private Integer wordRank;
    @JsonProperty("headWord")
    private String headWord;
    @JsonProperty("content")
    private ContentDTO content;
    @JsonProperty("bookId")
    private String bookId;

    @NoArgsConstructor
    @Data
    public static class ContentDTO {
        @JsonProperty("word")
        private WordDTO word;

        @NoArgsConstructor
        @Data
        public static class WordDTO {
            @JsonProperty("wordHead")
            private String wordHead;
            @JsonProperty("wordId")
            private String wordId;
            @JsonProperty("content")
            private ContentDTO.WordDTO.Content2DTO content;

            @NoArgsConstructor
            @Data
            public static class Content2DTO {
                @JsonProperty("sentence")
                private ContentDTO.WordDTO.Content2DTO.SentenceDTO sentence;
                @JsonProperty("usphone")
                private String usphone;
                @JsonProperty("ukspeech")
                private String ukspeech;
                @JsonProperty("star")
                private Integer star;
                @JsonProperty("usspeech")
                private String usspeech;
                @JsonProperty("syno")
                private ContentDTO.WordDTO.Content2DTO.SynoDTO syno;
                @JsonProperty("ukphone")
                private String ukphone;
                @JsonProperty("phrase")
                private ContentDTO.WordDTO.Content2DTO.PhraseDTO phrase;
                @JsonProperty("phone")
                private String phone;
                @JsonProperty("speech")
                private String speech;
                @JsonProperty("remMethod")
                private ContentDTO.WordDTO.Content2DTO.RemMethodDTO remMethod;
                @JsonProperty("relWord")
                private ContentDTO.WordDTO.Content2DTO.RelWordDTO relWord;
                @JsonProperty("trans")
                private List<ContentDTO.WordDTO.Content2DTO.TransDTO> trans;

                @NoArgsConstructor
                @Data
                public static class SentenceDTO {
                    @JsonProperty("sentences")
                    private List<ContentDTO.WordDTO.Content2DTO.SentenceDTO.SentencesDTO> sentences;
                    @JsonProperty("desc")
                    private String desc;

                    @NoArgsConstructor
                    @Data
                    public static class SentencesDTO {
                        @JsonProperty("sContent")
                        private String sContent;
                        @JsonProperty("sCn")
                        private String sCn;
                    }
                }

                @NoArgsConstructor
                @Data
                public static class SynoDTO {
                    @JsonProperty("synos")
                    private List<ContentDTO.WordDTO.Content2DTO.SynoDTO.SynosDTO> synos;
                    @JsonProperty("desc")
                    private String desc;

                    @NoArgsConstructor
                    @Data
                    public static class SynosDTO {
                        @JsonProperty("pos")
                        private String pos;
                        @JsonProperty("tran")
                        private String tran;
                        @JsonProperty("hwds")
                        private List<ContentDTO.WordDTO.Content2DTO.SynoDTO.SynosDTO.HwdsDTO> hwds;

                        @NoArgsConstructor
                        @Data
                        public static class HwdsDTO {
                            @JsonProperty("w")
                            private String w;
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class PhraseDTO {
                    @JsonProperty("phrases")
                    private List<ContentDTO.WordDTO.Content2DTO.PhraseDTO.PhrasesDTO> phrases;
                    @JsonProperty("desc")
                    private String desc;

                    @NoArgsConstructor
                    @Data
                    public static class PhrasesDTO {
                        @JsonProperty("pContent")
                        private String pContent;
                        @JsonProperty("pCn")
                        private String pCn;
                    }
                }

                @NoArgsConstructor
                @Data
                public static class RemMethodDTO {
                    @JsonProperty("val")
                    private String val;
                    @JsonProperty("desc")
                    private String desc;
                }

                @NoArgsConstructor
                @Data
                public static class RelWordDTO {
                    @JsonProperty("rels")
                    private List<ContentDTO.WordDTO.Content2DTO.RelWordDTO.RelsDTO> rels;
                    @JsonProperty("desc")
                    private String desc;

                    @NoArgsConstructor
                    @Data
                    public static class RelsDTO {
                        @JsonProperty("pos")
                        private String pos;
                        @JsonProperty("words")
                        private List<ContentDTO.WordDTO.Content2DTO.RelWordDTO.RelsDTO.WordsDTO> words;

                        @NoArgsConstructor
                        @Data
                        public static class WordsDTO {
                            @JsonProperty("hwd")
                            private String hwd;
                            @JsonProperty("tran")
                            private String tran;
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class TransDTO {
                    @JsonProperty("tranCn")
                    private String tranCn;
                    @JsonProperty("descOther")
                    private String descOther;
                    @JsonProperty("descCn")
                    private String descCn;
                    @JsonProperty("pos")
                    private String pos;
                    @JsonProperty("tranOther")
                    private String tranOther;
                }
            }
        }
    }
}
