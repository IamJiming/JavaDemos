package com.jiming.tool.constants;

/**
 * 功能：存储在数据库的动态常量
 * 说明：原本应该定义为一个key值，用于从字典表中查数据，
 *      因为这部分代码没有写（方便代码运行），所以在这么先定义死！！
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class ParamInDBConstant {
	/**
     * 服务方 URL
     */
    public static final String connectUrl = "http://127.0.0.1:8443/demosServer/api/YCHN001/%s/1.0.0";
    /**
     * 服务方 公钥
     */
    public static final String servicePublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyEJW+y8l8RWrgY+Xwj0y\n" +
            "MngnP++9IPMGpRqt1BPzVhWFelZ0Io9IFClOOio8Qb7RA8wDPAqsiOsI1NbGUnsR\n" +
            "CVVj/jKaJKGofecZjzr5MzM9wU9NPUQ4ggbqpQj7HtYDH6v2R3Ii8nsvCENv/crr\n" +
            "aXOPquP0GClR7+F5SGXOJcTX/HLqTBoXGslpt6b4mJchHW2XyvFA7ZjvCKXJ+r8K\n" +
            "6AGem3GwpNBAn8RozZJ51pgmRbiNmqA27kQZfYEmXiKzHbPH3HR2KMpmm2VMrTkD\n" +
            "wf5x4ujOZ9nT9chXCI1AqkMF7Ui536a0z8YLeFNSIIHa7axQqJzNo5uo7UOKlSZq\n" +
            "fQIDAQAB";
    /**
     * 服务方 私钥
     */
    public static final String servicePrivateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDIQlb7LyXxFauB\n" +
            "j5fCPTIyeCc/770g8walGq3UE/NWFYV6VnQij0gUKU46KjxBvtEDzAM8CqyI6wjU\n" +
            "1sZSexEJVWP+Mpokoah95xmPOvkzMz3BT009RDiCBuqlCPse1gMfq/ZHciLyey8I\n" +
            "Q2/9yutpc4+q4/QYKVHv4XlIZc4lxNf8cupMGhcayWm3pviYlyEdbZfK8UDtmO8I\n" +
            "pcn6vwroAZ6bcbCk0ECfxGjNknnWmCZFuI2aoDbuRBl9gSZeIrMds8fcdHYoymab\n" +
            "ZUytOQPB/nHi6M5n2dP1yFcIjUCqQwXtSLnfprTPxgt4U1IggdrtrFConM2jm6jt\n" +
            "Q4qVJmp9AgMBAAECggEAaqbiGh5PD6lh0Lt/sEPVMwnIpYVxbVXgyRd/Uj5ZzxPh\n" +
            "JXlbmnhCg/JHpjSOKNmOCX6ijlyE7Np3tpq3vn+qYBUpDt02OKIb0Qm+FAjtZPY6\n" +
            "QnSQhzuI+L7kQoaY7yA9Q6XaoMxJjmhKcRUxVLG4VE3mSrXibue6qo2jgQovEu9j\n" +
            "ORyfaljXJ9o717mJJLRz7ZG7m+GyFeCFnGYdV57Q1beW+GdZm/LJcXU1wzfZ4SxE\n" +
            "CZGLYUuhzaWbonRi48oq4BeKIpmUlTsWAVl6CioEvgtzBtA/0qlvgpgU1iDv1lcU\n" +
            "lsFbc4XkI+/++b6qnuAo8BXRycWRfpB/K8eCCgAipQKBgQD7QXtG/cYOwiouHxTc\n" +
            "69VeF11EaMvZaIJuq02KxTFJUZsoUJnY5PhxI74B68qH0b/F32HKo6qWgPnoiAvy\n" +
            "obIKiOgBNttGRA4qsd1GAFBdRMvu7Z+LZbM26wvY3ZCq6Jmfd+5OHfNNV0Qu7oL/\n" +
            "To9dJ6hEvvezsbaTDR3S6go6PwKBgQDMClnaEuEcNeeIRbdW7e2Jl+/iJ4pSUZKM\n" +
            "U/VbMVPtQP4uS7xQ3RkOa8YoCS2WdfVkCBeahdZwbVpRaBzCQPB+9nXuE6REsiLf\n" +
            "dMwlqNKvEfEdmWVoRraAq+NZNQ8KA/H6C/SIx9R8Woea6P2GKI5S6IFDk/s60VJo\n" +
            "6KDlcoPUQwKBgQCazRtg/9XZHfPS+r9l5b9N+2MxVMfTqTpDaTObPidBnw/TZOWE\n" +
            "5n3TZ0wX7uiXibl39ktQCEp/8/MFO1zxHoKNTxByPxQWVLPNxkwoZuUcsdhb2vej\n" +
            "cQNb4LEp6kjJpAmSYNfoNTfD/PI7YCRBnGtj350ize3bPrDYJQqs+hlXDQKBgA07\n" +
            "VpxXwRVtQXiK3NrcTx0vJzVJTyULeS90emLRjhnCrzkdXDb6P5e50X3jKnupZqJ4\n" +
            "C9/PchqUXNkOoV7Pi0kQfpFT4ME7tBs9nceLbS5BQZujyPm8LDWn7/RnBnSl0Nlg\n" +
            "URlVrCfsTwLyvQ4oLyKdRVS2kgI8dNWs0FJQ3M+1AoGBAJtAAL4F3+qlkYZSvHnq\n" +
            "6eGcQttxqVxhs6X5e+l94KbKisGNi171q8tLqUqxv3R9xCTdxPcJsyXmI/Ryw7e0\n" +
            "opM3rCK7nvzhvyr51ODbbVSP5OIugjcmEa1Pqmfs00rr1Q3i/ED53042vUzKGtYt\n" +
            "qID4hb5SzTFBXgtD86cPEyV2";
    /**
     * 合作方 公钥
     */
    public static final String workPrivateKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx62GjKhB2Rs4NXCKC7PA\n" +
            "PbxI8YXNJQ9eRTCe62vTEwOtqRCuP44HSYD2HhBEeAfIt/2ufCr2eZ4+ZKLtm39x\n" +
            "peqjOF5Cmie758uriralk/SLqmiH5mBQqnKiJtULLwpZlpeZ+0fP+xfEIP0AuObY\n" +
            "MAiI7+JT0CZ5/dIjacSXClcBE67USPF8GsBhrCJaKasTdCsY2HPPCSMruUGw54o+\n" +
            "x0Ju6HMdw2kKqi3D2JK3GBXxJQVOpO6pUZDCTz6YqAYaHIAb0MTcH+/00H9dbI36\n" +
            "8O+z9WyPGtQyVbyi1PkRFAB+2LSZstpP9dvo9jEfUf1YA9uvj2bLeVDXIzgPkMsa\n" +
            "JwIDAQAB";
    /**
     * 合作方 私钥
     */
    public static final String workPublicKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDHrYaMqEHZGzg1\n" +
            "cIoLs8A9vEjxhc0lD15FMJ7ra9MTA62pEK4/jgdJgPYeEER4B8i3/a58KvZ5nj5k\n" +
            "ou2bf3Gl6qM4XkKaJ7vny6uKtqWT9IuqaIfmYFCqcqIm1QsvClmWl5n7R8/7F8Qg\n" +
            "/QC45tgwCIjv4lPQJnn90iNpxJcKVwETrtRI8XwawGGsIlopqxN0KxjYc88JIyu5\n" +
            "QbDnij7HQm7ocx3DaQqqLcPYkrcYFfElBU6k7qlRkMJPPpioBhocgBvQxNwf7/TQ\n" +
            "f11sjfrw77P1bI8a1DJVvKLU+REUAH7YtJmy2k/12+j2MR9R/VgD26+PZst5UNcj\n" +
            "OA+QyxonAgMBAAECggEBAMYX76jxb8osR9o0WK99V1WnypHZlQiUM4je0HpsEQ4H\n" +
            "EyzrwIKKq84PI5v1tYeC6W0nPggvMzC6fdmnDaS7jYr1uZG9acO3caJnGzrVMnUT\n" +
            "IdAgPdqeaMiASz/NEXhMg05z/i4dM0c+b7Pua94EHiug/AFH/rA8y7+0zq8qelGk\n" +
            "9uCqZy5ZUlL7gVzy1/WCIyapU63jmwNun9GdVCM942tASOyoheIklJNx2vk98AJb\n" +
            "0pjLSqMJeOC6yzvQKiaJJwyJRalWJVtwrwJJYm0AAsOaAi95P99w6kAiCD5sM5j9\n" +
            "OP6S6RVlgc8xKnVbxkiJdWULB8DJIhNznTZ8h76qeGkCgYEA9cffRC24wKqoU5CR\n" +
            "Mk1cZE9rIvAtJe6zrJMELORCDPemyvjvRimGIkpU0u/Hd2DbLmy1my6nNBRX0khv\n" +
            "uU/UVTC3D8WdVmnFTM252HfhITxWVcxOVG5X+p0ZhBmoZHc9KUicQavA2uHgy7jl\n" +
            "oWO0EoWFECRFQPse6x2gycxHLaUCgYEAz/rtTY2K/4veiSaQPhoLwMq6+3lYe1SZ\n" +
            "x57tChuRZ5J1+GPKH4sSaPWB7BLksAmmBTeBrluaRDScz4pXIqHo6aGFKjm8JlY5\n" +
            "Gtqgva5KuQCv2fScWAFCS5nkgerxyjqdiPJ44haweQhMdH6qyn4xRuq47ex4369S\n" +
            "1RP5sRDZdtsCgYEAtvuPZZsEqaxklZJUBzdBSg02nlRhyJPmgN0ThriJ1E2siAC9\n" +
            "Y2cWzgC5FjIeNuqNRAr7SgV5xnQ+zffP9g9Q7fvOzpc5hFRK59tiOZ9GpQ/e1xG8\n" +
            "X2+nYJYFoSvZCrMbfdjpPJs6gbsZOZL2oykvr3pojpPyW2aapkDwrEzB0WECgYBj\n" +
            "TSCehbVXHDYtb88xB4iTDXjHdwGrKRKfgB8XU2BSflh7N1IbS3CH0qisybyM3J57\n" +
            "ISx2zl/SrvgsE5ZU/89QNYF6TsSp3UM4sihLSHt+53gO7b70Oe2oYRr8eOvnLaNn\n" +
            "7rWO5Vxu/WpbuNrdAfGPNaUEXIK98lzvRbFTPINIPwKBgQCkLLCC6zAqHGdE1kO5\n" +
            "5+JCkDNOZTsID4qBi5Ga1BxRV8zQRboR3CWOoTo2npQ8DefDxaPycT4sJ4x1OV+Y\n" +
            "Jl6/7OsosQBxy1mY0uTRfsS3et+hK2fdUfu+YGwYl0eNcvhKsxTIK7WeSPdfZyeZ\n" +
            "BYygnioEatS9e1caRzWYQH+7QA==";

}
