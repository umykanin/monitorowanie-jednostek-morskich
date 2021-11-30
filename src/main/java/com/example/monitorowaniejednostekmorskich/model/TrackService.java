package com.example.monitorowaniejednostekmorskich.model;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrackService {

    public String get() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjBCM0I1NEUyRkQ5OUZCQkY5NzVERDMxNDBDREQ4OEI1QzA5RkFDRjMiLCJ0eXAiOiJhdCtqd3QiLCJ4NXQiOiJDenRVNHYyWi03LVhYZE1VRE4ySXRjQ2ZyUE0ifQ.eyJuYmYiOjE2MzgyMDc0MzgsImV4cCI6MTYzODIxMTAzOCwiaXNzIjoiaHR0cHM6Ly9pZC5iYXJlbnRzd2F0Y2gubm8iLCJhdWQiOiJhcGkiLCJjbGllbnRfaWQiOiJ1bXlrYW5pbkBnbWFpbC5jb206dW15a2FuaW4iLCJzY29wZSI6WyJhcGkiXX0.bL1yH4E56FLKE6NaZqST1aN2UWoNt9VWTwv2ajK-DYVuI-RYLVZc68go_fLk9RWiJ6T6zFj3YF8X0aY0i8AAB0KwN4wMTcqzmyXohOllrDsgtJdDukaV7pqfTur_geRyOw5u6FS1IUfXrTWRBs3pj1DYmgrxtEjNaUke6rElEGphwumTwl268kFW0yzob2bJX7Rr4zZTyvlVeV7WT4wfYHbOiK5_VUKO0WizVYLNdYTUKSP3qj5SZG2LfPXUt7qNyGFRJNaDl64O0Wv7LxJl_eHSlHyt_E79ZNiu9x_ktoD_j4ADCBqHbCXy83EGDsTOdKWji--S3s8m1L7Uorf6ixm0LJYpiL3PfBRyDDJEpp60kXMM3purKMxopNZ8m8zSjmsy0_UWQgKLGzlJSugg0K1__FMyK4wUVNCFjDQdYdALvTTAZqE4Fc83a5ZINStYWokMcBaf5v_WRz5q-0GbxQaJBzKBt9i0dazhOh4H4I7PdqCqb5mZXBKufFaW6px0_p1qRoAb7pBaojwMdXRzPc2uMnD42-Sttv7DwgKOzP0AdTG2FYBic0PDgel3FClOZZDEDf-0D102070yE3_-KuK3dMil7TSEYCtFeCYsTGKmTtRSVFJBrLrqdXf5yfdjqV5TBz6PcZDmnWDVWafo2CPmiMY6j_eAG7UQ6U7szAI");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        restTemplate.exchange("https://www.barentswatch.no/bwapi/v2/geodata/ais/openpositions?Xmin=10.09094&Xmax=10.67047&Ymin=63.3989&Ymax=63.58645",
                HttpMethod.GET, httpEntity, Track[].class);
    }
}
