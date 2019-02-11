import { Moment } from 'moment';

export const enum Language {
    ENGLISH = 'ENGLISH',
    GERMAN = 'GERMAN',
    DUTCH = 'DUTCH'
}

export const enum CompanyGroup {
    AA = 'AA',
    BB = 'BB',
    CC = 'CC'
}

export interface IJournalS {
    id?: number;
    objectId?: string;
    objectName?: string;
    productId?: string;
    title?: string;
    shortTitle?: string;
    primaryLanguage?: Language;
    companyGroup?: CompanyGroup;
    publisher?: string;
    publishingSegment?: string;
    imprint?: string;
    medium?: string;
    creationDate?: Moment;
    nameOfSociety?: string[];
    onlineServices?: string[];
}

export class JournalS implements IJournalS {
    constructor(
        public id?: number,
        public objectId?: string,
        public objectName?: string,
        public productId?: string,
        public title?: string,
        public shortTitle?: string,
        public primaryLanguage?: Language,
        public companyGroup?: CompanyGroup,
        public publisher?: string,
        public publishingSegment?: string,
        public imprint?: string,
        public medium?: string,
        public creationDate?: Moment,
        public nameOfSociety?: string[],
        public onlineServices?: string[]
    ) {}
}
